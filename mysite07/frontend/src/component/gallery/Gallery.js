import React, { useState, useEffect } from 'react';
import { MySiteLayout } from '../../layout';
import Header from './Header';
import ImageList from './ImageList';
import styles from '../../assets/scss/component/gallery/Gallery.scss';
import data from '../../assets/json/data';
import axios from 'axios';

export default function Index() {
    const [imageList, setImageList] = useState(data);

    const addImage = async (comment, file) => {
        try {
            const formData = new FormData();
            formData.append('comments', comment);
            formData.append('file', file);

            const response = await axios.post('/api/gallery', formData, {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'multipart/form-data',
                },
            });

            if (response.status !== 200) {
                throw `${response.status} ${response.statusText}`;
            }

            const json = response.data;
            if (json.result !== 'success') {
                throw json.message;
            }

            setImageList([json.data, ...imageList]);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <MySiteLayout>
            <div className={styles.Gallery}>
                <Header addImage={addImage} />
                <ImageList imageList={imageList} />
            </div>
        </MySiteLayout>
    );
}
