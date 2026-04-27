import Header from '../components/Header';
import Footer from '../components/Footer';
import '../css/JobAppSubmission.css'

function JobAppSubmission() {
    return(
        <>
            <Header />
            <main className='job-app-submission'>
                <h1>Submit an Application</h1>
                <section className='form-section'>
                    <form>
                        <label for='job-title'>Job Title</label>
                        <input type='text' id='job-title' name='job-title'></input><br></br>
                        <label for='company'>Company</label>
                        <input type='text' id='company' name='company'></input><br></br>
                        <label for='hourly-pay'>Hourly Pay</label>
                        <input type='text' id='hourly-pay' name='hourly-pay'></input><br></br>
                        <label for='app-status'>Application Status</label>
                        <select id='app-status' name='app-status'>
                            <option value='applied'>Applied</option>
                            <option value='applied'>Interviewed</option>
                            <option value='applied'>Offer</option>
                            <option value='applied'>Rejected</option>
                        </select>
                    </form>
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppSubmission;