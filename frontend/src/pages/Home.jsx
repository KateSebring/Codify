import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/Home.module.css';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <>
            <Header />
            <main className={styles.heroPage}>
                <h1 className={styles.tagline}>Your center for tracking job applications.</h1>
                <Link to="/register">
                    <button type="button" className={styles.primaryCTA}>Register Now</button>
                </Link>
            </main>
            <Footer />
        </>
    )
}

export default Home;