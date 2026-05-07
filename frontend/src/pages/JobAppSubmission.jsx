import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/FormPages.module.css'
import { useNavigate } from "react-router-dom";
import React, { useState} from 'react';
import { API_URL } from '../config';

function JobAppSubmission() {
    const [formData, setFormData] = useState(
            {
                positionTitle: '',
                company: '',
                salary: '',
                jobListingURL: '',
                status: '',
                dateApplied: ''
            }
        );

    const navigate = useNavigate(); 

    const handleChange = (e) => {
        setFormData({...formData, [e.target.name]: e.target.value});
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(`${API_URL}/api/applications`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
                credentials: 'include'
            });

            if(response.ok) {
                alert("Job application successfully created!");
                navigate('/dashboard');
            }
        } catch (err) {
            alert("Submission failed. " + err);
        }
    }

    return(
        <>
            <Header />
            <main>
                <h1 className='pageTitle'>Submit an Application</h1>
                <section className={styles.formSection}>
                    <form className={styles.form} onSubmit={handleSubmit}>
                        <p className={styles.formNote}>* = required</p>
                        <div className={styles.formOption}>
                            <label htmlFor='positionTitle'>Position Title<span className='required'>*</span></label>
                            <input type='text' id='positionTitle' name='positionTitle' onChange={handleChange}></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='company'>Company<span className='required'>*</span></label>
                            <input type='text' id='company' name='company' onChange={handleChange}></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='salary'>Hourly Pay<span className='required'>*</span></label>
                            <input type='text' id='salary' name='salary' onChange={handleChange}></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='jobListingURL'>Job Listing URL<span className='required'>*</span></label>
                            <input type='text' id='jobListingURL' name='jobListingURL' onChange={handleChange}></input>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='status'>Application Status<span className='required'>*</span></label>
                            <select id='status' name='status' onChange={handleChange}>
                                <option value='applied'>Applied</option>
                                <option value='interview'>Interviewed</option>
                                <option value='offer'>Offer</option>
                                <option value='rejected'>Rejected</option>
                            </select>
                        </div>

                        <div className={styles.formOption}>
                            <label htmlFor='dateApplied'>Date of Birth<span className='required'>*</span></label>
                            <input type='date' id='dateApplied' name='dateApplied' onChange={handleChange}></input>
                        </div>

                        <div className={styles.formOption}>
                            <input type='submit' className={styles.submitForm} value='Submit'></input>
                        </div>
                    </form>
                </section>
            </main>
            <Footer />
        </>
    )
}

export default JobAppSubmission;