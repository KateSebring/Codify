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
                    <input type='text'></input>
                </form>
            </section>
            <Footer />
        </>
    )
}

export default Register;