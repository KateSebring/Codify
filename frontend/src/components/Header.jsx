import '../css/Header.css';
import logo from '../logo.png';
import { Link } from 'react-router-dom';
import { useAuth } from '../hooks/useAuth';
import { API_URL } from '../config'
import { useNavigate } from "react-router-dom";

function Header() {
    const navigate = useNavigate();
    const {
        setAuthUser,
        isLoggedIn,
        loading
    } = useAuth();

    async function handleLogout() {
        try {
            const response = await fetch(`${API_URL}/api/auth/logout`, {
                method: "POST",
                credentials: "include"
            });

            if(response.ok) {
                setAuthUser(null);
                navigate('/login');
            }
        } catch (err) {
            alert("Something went wrong! " + err);
        }
    }

    return(
        <>
            <header>
                <img src={logo} alt="Codify logo" />
                <nav>
                    {loading ? null : (
                        <ul id="header-items">
                            <li><Link to="/" className='nav-link'>Home</Link></li>
                            {!isLoggedIn ? (
                                <>
                                    <li><Link to="/register" className='nav-link'>Register</Link></li>
                                    <li><Link to="/login" className='nav-link'>Login</Link></li>
                                </>
                            ) : (
                                <>
                                    <li><Link to="/dashboard" className='nav-link'>Dashboard</Link></li>
                                    <li className='nav-link logout' onClick={() => handleLogout()}>Logout</li>
                                </>
                            )}
                        </ul>
                    )}
                </nav>
            </header>
        </>
    );
}

export default Header;