import '../css/Header.css';
import logo from '../logo.png';
import { Link } from 'react-router-dom';
function Header() {
    return(
        <>
            <header>
                <img src={logo} alt="Codify logo" />
                <nav>
                    <ul id="header-items">
                        <li><Link to="/" className='nav-link'>Home</Link></li>
                        <li><Link to="/register" className='nav-link'>Register</Link></li>
                        <li><Link to="/login" className='nav-link'>Login</Link></li>
                    </ul>
                </nav>
            </header>
        </>
    );
}

export default Header;