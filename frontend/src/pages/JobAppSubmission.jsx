import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/JobAppSubmission.module.css'

function JobAppSubmission() {
    return(
        <>
            <Header />
            <main>
                <h1 className={styles.jobSubmissionHeader}>Submit an Application</h1>
                <section className={styles.formSection}>
                    <form className={styles.jobAppForm}>
                        <p className={styles.formNote}>* = required</p>
                        <div className={styles.formOption}>
                            <label htmlFor='job-title'>Job Title<span className='required'>*</span></label>
                            <input type='text' id='job-title' name='job-title'></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='company'>Company<span className='required'>*</span></label>
                            <input type='text' id='company' name='company'></input>
                        </div>

                        <div className={styles.formOption}>
                        <label htmlFor='hourly-pay'>Hourly Pay<span className='required'>*</span></label>
                        <input type='text' id='hourly-pay' name='hourly-pay'></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='app-status'>Application Status<span className='required'>*</span></label>
                            <select id='app-status' name='app-status'>
                                <option value='applied'>Applied</option>
                                <option value='applied'>Interviewed</option>
                                <option value='applied'>Offer</option>
                                <option value='applied'>Rejected</option>
                            </select>
                        </div>

                        <div className={styles.formOption}>
                            <input type='button' className={styles.submitForm} value='Submit'></input>
                        </div>
                    </form>
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppSubmission;