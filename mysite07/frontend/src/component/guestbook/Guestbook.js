import { useEffect, useState } from 'react';
import React from 'react';
import { MySiteLayout } from "../../layout";
import styles from '../../assets/scss/component/guestbook/Guestbook.scss';
import { readAll } from '../../service/guestbook.service';
import MessageList from './MessgaeList';
import WriteForm from './WriteForm';


const Guestbook = () => {

    const [guests, setGuests] = useState([]);
    const handleAddGuest = (updatedGuestbook) => {
        setGuests(updatedGuestbook);
    };

    useEffect(() => {
        readAll()
            .then(response => {
                console.log(`Received the response from API ${response.data}`);
                setGuests(response.data);
            })
            .catch(error => {
                console.log(`Error occurred ${error}`);
            });
    }, []);
    return (
        <MySiteLayout>
            <div className={styles.Guestbook}>
                <h2>방명록</h2>
                <WriteForm onAddGuest={handleAddGuest} />
                <MessageList messages={guests} />
                
            </div>
        </MySiteLayout>
    );
}

export default Guestbook;