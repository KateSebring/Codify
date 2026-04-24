import '../css/JobAppCard.css';

function JobAppCard() {
    return(
        <>
            <article className='jobAppCard'>
                <ul className='jobTitle'>
                    <li>Job Title</li>
                </ul>
                <ul>
                    <li>$0.00/hr</li>
                    <li>Company Name</li>
                    <li>Applied 01/01/2026</li>
                    <li><b>Status</b></li>
                </ul>
                <div className='button-row'>
                    <button type='button'>Edit</button>
                    <button type='button'>Delete</button>
                </div>
            </article>
        </>
    );
}

export default JobAppCard;