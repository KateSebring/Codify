import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/FormPages.module.css';
import React, { useState } from 'react';
import { API_URL } from '../config';
import { useNavigate } from "react-router-dom";
import { useAuth } from '../hooks/useAuth';

function Login() {
    const { setAuthUser } = useAuth();
    const navigate = useNavigate(); 

    const [formData, setFormData] = useState(
        {
            username: '',
            password: ''
        }
    );

    const handleChange = (e) => {
        setFormData({...formData, [e.target.name]: e.target.value});
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(`${API_URL}/api/auth/login`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
                credentials: 'include'
            });

            if(response.ok) {
                const userRes = await fetch(`${API_URL}/api/auth/checkAuth`, {
                    method: 'GET',
                    credentials: 'include'
                });

                const user = await userRes.json();

                setAuthUser(user);
                navigate('/dashboard');
            }
        } catch (err) {
            alert("Login failed. " + err);
        }
    }

    return(
        <>
    <       Header />
            <h1 className='pageTitle'>Login</h1>
            <section className={styles.formSection}>
                <form className={styles.form} onSubmit={handleSubmit}>
                    <p className={styles.formNote}>* = required</p>
                    <div className={styles.formOption}>
                        <label for='username'>Username<span className='required'>*</span></label>
                        <input type='text' id='username' name='username' onChange={handleChange}></input>
                    </div>

                    <div className={styles.formOption}>
                        <label for='password'>Password<span className='required'>*</span></label>
                        <input type='password' id='password' name='password' onChange={handleChange}></input>
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

export default Login;