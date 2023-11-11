import httpClient from "../api/http-common";

export const readAll = () => {
  return httpClient.get("/guestbook")
}


export const addGuest = (name, password, contents) => {
  try {
    return httpClient.post('/guestbook', {
      name,
      password,
      contents,
    });

    // 성공한 경우 서버에서 반환한 데이터 또는 다른 정보를 처리할 수 있음
  } catch (error) {
    console.error('Error occurred while adding guestbook entry:', error);
    throw error;
  }
}



export default readAll;