import Header from '../components/Header';
import Footer from '../components/Footer';
import '../css/JobAppSubmission.css'

function JobAppSubmission() {
    return(
        <>
            <Header />
            <main>
                <h1 className='job-submission-header'>Submit an Application</h1>
                <section className='form-section'>
                    <form class='job-app-form'>
                        <div className='form-option'>
                            <label for='job-title'>Job Title</label>
                            <input type='text' id='job-title' name='job-title' placeholder='Job title...'></input>
                        </div>

                        <div className='form-option'>
                            <label for='company'>Company</label>
                            <input type='text' id='company' name='company' placeholder='Company...'></input>
                        </div>

                        <div className='form-option'>
                        <label for='hourly-pay'>Hourly Pay</label>
                        <input type='text' id='hourly-pay' name='hourly-pay' placeholder='0.00'></input>
                        </div>

                        <div className='form-option'>
                            <label for='app-status'>Application Status</label>
                            <select id='app-status' name='app-status'>
                                <option value='applied'>Applied</option>
                                <option value='applied'>Interviewed</option>
                                <option value='applied'>Offer</option>
                                <option value='applied'>Rejected</option>
                            </select>
                        </div>

                        <div className='form-option'>
                            <input type='button' className='submit-form' value='Submit'></input>
                        </div>
                    </form>
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppSubmission;