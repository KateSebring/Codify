/* eslint-disable no-unused-vars */
import React, {useState, useEffect} from 'react';
import { AuthContext } from './AuthContext';

export function AuthProvider({ children }) {
    const [authUser, setAuthUser] = useState(null);
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function checkAuth() {
            try {
               const res = await fetch("/api/auth/checkAuth", {
                    credentials: "include"
               });

               if(res.ok) {
                const user = await res.json();
                setAuthUser(user);
                setIsLoggedIn(true);
               } else {
                setAuthUser(null);
                setIsLoggedIn(false);
               }
            } catch (err) {
                setAuthUser(null);
                setIsLoggedIn(false);
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
        setIsLoggedIn
    }

    return(
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}