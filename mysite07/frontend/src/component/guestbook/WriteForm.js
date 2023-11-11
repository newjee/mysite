import React from 'react';
import { useState } from 'react';
import { addGuest } from '../../service/guestbook.service';
import styles from '../../assets/scss/component/guestbook/WriteForm.scss';

const WriteForm = () => {
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [contents, setContents] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // 서버에 데이터를 전송
      await addGuest(name, password, contents);
      const updatedGuestbook = await readAll();
      
      onAddGuest(updatedGuestbook);

      console.log('Updated Guestbook:', updatedGuestbook);
      
      // 입력 폼 초기화
      setName('');
      setPassword('');
      setContents('');
    } catch (error) {
      console.error('Error occurred while submitting guestbook entry:', error);
    }
  };


  return (
    <div id="guestbook" className={styles.WriteFrom}>
      <form onSubmit={handleSubmit}>
        <table>
          <tr>
            <td>이름</td>
            <td>
              <input
                type="text"
                name="name"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </td>
            <td>비밀번호</td>
            <td>
              <input
                type="password"
                name="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan={4}>
              <textarea
                name="contents"
                id="content"
                value={contents}
                onChange={(e) => setContents(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan={4} align="right">
              <input type="submit" value="확인" />
            </td>
          </tr>
        </table>
      </form>
    </div>
  );
};

export default WriteForm;
