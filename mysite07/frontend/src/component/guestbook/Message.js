import React from 'react';
import styles from '../../assets/scss/component/guestbook/Message.scss';

const Message = ({ name, contents, regDate }) => {
    return (
        <div className={styles.Message}>
            <strong>{name}</strong>
            <p>{contents}</p>
            <a href="#" className={styles.deleteIcon}></a>
            <span>{regDate}</span>
        </div>
    );
}

export default Message;
