import Header from '../components/Header';
import Footer from '../components/Footer';
import JobAppCard from '../components/JobAppCard'
import styles from '../css/JobAppDashboard.module.css'
import { useAuth } from '../hooks/useAuth';
import { API_URL } from '../config';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from 'react';

function JobAppDashboard() {
    const { loading, isLoggedIn } = useAuth();
    const [applications, setApplications] = useState([]);

    const navigate = useNavigate();
    useEffect(() => {
        if(!loading && !isLoggedIn) {
            navigate('/login');
            return;
        }
    }, [isLoggedIn, loading, navigate]);
    
    // send a fetch request to the backend
    // as soon as received, check if empty
    useEffect(() => {
        if (loading || !isLoggedIn) return;

        const fetchApplications = async () => {
            try {
                const response = await fetch(`${API_URL}/api/applications`, {
                    method: 'GET',
                    credentials: 'include'
                });

                const data = await response.json();

                setApplications(data);

            } catch (err) {
                alert("Something went wrong. " + err);
            }
        }

        fetchApplications();
    }, []);

    return (
        <>
            <Header />
            <main>
                <h1 className='pageTitle'>Your Applications</h1>
                <section className={styles.jobAppSection}>
                    {applications.length === 0 ? (
                        <p className={styles.noAppsFound}>No applications found.</p>
                    ) : (
                        applications.map(app => (
                            <JobAppCard key={app.id} application={app} />
                        ))
                    )}
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppDashboard;