import styles from '../css/JobAppCard.module.css';

function JobAppCard() {
    return(
        <>
            <article className={styles.jobAppCard}>
                <ul className={styles.jobTitle}>
                    <li>Job Title</li>
                </ul>
                <ul>
                    <li>$0.00/hr</li>
                    <li>Company Name</li>
                    <li>Applied 01/01/2026</li>
                    <li><b>Status</b></li>
                </ul>
                <div className={styles.buttonRow}>
                    <button type='button' className={styles.jobCardActionButtons}>Edit</button>
                    <button type='button' className={styles.jobCardActionButtons}>Delete</button>
                </div>
            </article>
        </>
    );
}

export default JobAppCard;