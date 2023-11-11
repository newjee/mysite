import React from 'react';
import Message from './Message';
import styles from '../../assets/scss/component/guestbook/MessageList.scss';
const MessageList = ({ messages }) => {
  return (
    <div className={styles.MessageList}>
      {messages.map(message => (
        <Message
          key={message.id}
          name={message.name}
          contents={message.contents}
          regDate={message.regDate}
        />
      ))}
    </div>
  );
}

export default MessageList;
