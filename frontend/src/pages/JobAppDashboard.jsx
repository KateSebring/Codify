import Header from '../components/Header';
import Footer from '../components/Footer';
import JobAppCard from '../components/JobAppCard'
import styles from '../css/JobAppDashboard.module.css'
import { useAuth } from '../hooks/useAuth';
import { useNavigate } from "react-router-dom";
import { useEffect } from 'react';

function JobAppDashboard() {
    const { loading, isLoggedIn } = useAuth();
    const navigate = useNavigate();
    
    useEffect(() => {
        if(!loading && !isLoggedIn) {
            navigate('/login');
        }
    }, [isLoggedIn, loading, navigate]);

    return (
        <>
            <Header />
            <main>
                <h1 className='pageTitle'>Your Applications</h1>
                <section className={styles.jobAppSection}>
                    <JobAppCard />
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppDashboard;