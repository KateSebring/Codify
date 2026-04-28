import Header from "../components/Header.jsx"
import Footer from "../components/Footer.jsx"
import styles from "../css/PageNotFound.module.css"
function PageNotFound() {
    return(
        <>
            <Header />
            <main className={styles.mainContent}>
                <h1 className="pageTitle">404 | Page Not Found</h1>
                <p className={styles.notFoundMessage}>Page requested was not found.</p>
            </main>
            <Footer />
        </>
    )
}

export default PageNotFound; 