import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from '../css/Login.module.css'
function Login() {
    return(
        <>
    <       Header />
            <h1 className={styles.header}>Login</h1>
            <section className={styles.loginFormSection}>
                <form className={styles.loginForm}>
                    <div className={styles.formOption}>
                        <label for='username'>Username</label>
                        <input type='text' id='username' name='username'></input>
                    </div>

                    <div className={styles.formOption}>
                        <label for='password'>Password</label>
                        <input type='password' id='password' name='password'></input>
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

export default Login;