/* eslint-disable no-unused-vars */
import React, {useState, useEffect} from 'react';
import { AuthContext } from './AuthContext';
import { API_URL } from '../config'

export function AuthProvider({ children }) {
    const [authUser, setAuthUser] = useState(null);
    const [loading, setLoading] = useState(true);

    const isLoggedIn = !!authUser;

    useEffect(() => {
        async function checkAuth() {
            try {
               const res = await fetch(`${API_URL}/api/auth/checkAuth`, {
                    method: 'GET',
                    credentials: 'include'
               });

               if(res.ok) {
                const user = await res.json();
                setAuthUser(user);
               } else {
                setAuthUser(null);
               }
            } catch (err) {
                setAuthUser(null);
            } finally {
                setLoading(false);
            }
        }

        checkAuth();
    }, []);

    const value = {
        authUser,
        setAuthUser,
        isLoggedIn,
        loading
    }

    return(
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}