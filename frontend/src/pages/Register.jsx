import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/Register.module.css'
function Register() {
    return(
        <>
            <Header />
            <h1 className={styles.header}>Register</h1>
            <section className={styles.registerFormSection}>
                <form className={styles.registrationForm}>
                    <div className={styles.formOption}>
                        <label for='firstName'>First Name</label>
                        <input type='text' id='firstName' name='firstName'></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label for='lastName'>Last Name</label>
                        <input type='text' id='lastName' name='lastName'></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label for='username'>Username</label>
                        <input type='text' id='username' name='username'></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label for='password'>Password</label>
                        <input type='password' id='password' name='password'></input>
                    </div>
                    
                    <div className={styles.formOption}>
                        <label for='email'>Email Address</label>
                        <input type='email' id='email' name='email'></input>
                    </div>

                    <div className={styles.formOption}>
                        <label for='dateOfBirth'>Date of Birth</label>
                        <input type='date' id='dateOfBirth' name='dateofBirth'></input>
                    </div>

                    <div className={styles.formOption}>
                        <input type='button' className={styles.submitForm} value='Submit'></input>
                    </div>
                </form>
            </section>
            <Footer />
        </>
    )
}

export default Register;