import Header from '../components/Header';
import Footer from '../components/Footer';
import JobAppCard from '../components/JobAppCard'
import '../css/JobAppDashboard.css'

function JobAppDashboard() {
    return (
        <>
            <Header />
            <main className='dashboard'>
                <h1 className='page-header'>Your Applications</h1>
                <section className='job-app-section'>
                    <JobAppCard />

                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppDashboard;