import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/FormPages.module.css';
import React, { useState, useEffect } from 'react';
import { API_URL } from '../config';
import { useNavigate } from "react-router-dom";
import { useAuth } from '../hooks/useAuth';

function Register() {
    const { isLoggedIn, loading } = useAuth();
    const navigate = useNavigate(); 

    useEffect(() => {
        if (!loading && isLoggedIn) {
            navigate("/dashboard");
        }
    }, [isLoggedIn, loading, navigate]);
                    
    const [formData, setFormData] = useState(
        {
            firstName: '',
            lastName: '',
            username: '',
            email: '',
            password: '',
            dob: ''
        }
    );

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        try {
            const response = await fetch(`${API_URL}/api/auth/register`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            });

            if(response.ok) {
                alert("Successfully registered!");
                navigate('/login');
            }
        } catch (err) {
            console.error("Problem submitting form: ", err);
        }
    };

    return(
        <>
            <Header />
            <h1 className='pageTitle'>Register</h1>
            <section className={styles.formSection}>
                <form className={styles.form} onSubmit={handleSubmit}>
                    <p className={styles.formNote}>* = required</p>
                    <div className={styles.formOption}>
                        <label htmlFor='firstName'>First Name<span className='required'>*</span></label>
                        <input type='text' id='firstName' name='firstName' onChange={handleChange}></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label htmlFor='lastName'>Last Name<span className='required'>*</span></label>
                        <input type='text' id='lastName' name='lastName' onChange={handleChange}></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label htmlFor='username'>Username<span className='required'>*</span></label>
                        <input type='text' id='username' name='username' onChange={handleChange}></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label htmlFor='password'>Password<span className='required'>*</span></label>
                        <input type='password' id='password' name='password' onChange={handleChange}></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label htmlFor='email'>Email Address<span className='required'>*</span></label>
                        <input type='email' id='email' name='email' onChange={handleChange}></input>
                    </div>

                    <div className={styles.formOption}>
                        <label htmlFor='dateOfBirth'>Date of Birth<span className='required'>*</span></label>
                        <input type='date' id='dateOfBirth' name='dob' onChange={handleChange}></input>
                    </div>

                    <div className={styles.formOption}>
                        <input type='submit' className={styles.submitForm} value='Submit'></input>
                    </div>
                </form>
            </section>
            <Footer />
        </>
    )
}

export default Register;