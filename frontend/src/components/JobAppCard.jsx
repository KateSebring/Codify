import styles from '../css/JobAppCard.module.css';

function JobAppCard({ application }) {
    return(
        <>
            <article className={styles.jobAppCard}>
                <ul className={styles.positionTitle}>
                    <li>{application.positionTitle}</li>
                </ul>
                <ul>
                    <li>${application.salary}/hr</li>
                    <li>{application.company}</li>
                    <li>Applied {application.dateApplied}</li>
                    <li><b>{application.status}</b></li>
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