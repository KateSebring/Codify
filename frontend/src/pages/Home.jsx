import Header from '../components/Header';
import Footer from '../components/Footer';
import '../css/Home.css';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <>
            <Header />
            <main>
                <h1>Your center for tracking job applications.</h1>
                <Link to="/register">
                    <button type="button">Register Now</button>
                </Link>
            </main>
            <Footer />
        </>
    )
}

export default Home;