import '../css/Header.css';
import logo from '../logo.png';

function Header() {
    return(
        <>
            <header>
                <img src={logo} alt="Codify logo" />
                <nav>
                    <ul id="header-links">
                        <li>Home</li>
                        <li>Register</li>
                        <li>Login</li>
                    </ul>
                </nav>
            </header>
        </>
    );
}

export default Header;