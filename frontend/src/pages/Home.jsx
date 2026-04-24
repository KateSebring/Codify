import Header from '../components/Header';
import Footer from '../components/Footer';
import '../css/Home.css';

function Home() {
    return (
        <>
            <Header />
            <main>
                <h1>Your center for tracking job applications.</h1>
                <button>Register Now</button>
            </main>
            <Footer />
        </>
    )
}

export default Home;