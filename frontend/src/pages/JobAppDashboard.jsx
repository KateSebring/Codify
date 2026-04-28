import Header from '../components/Header';
import Footer from '../components/Footer';
import JobAppCard from '../components/JobAppCard'
import styles from '../css/JobAppDashboard.module.css'

function JobAppDashboard() {
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