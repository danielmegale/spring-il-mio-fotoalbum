<script>
import axios from 'axios';

export default {
    data() {
        return {
            photos: [],
            originalPhotos: [],
            searchQuery: '',
        };
    },
    mounted() {
        this.fetchPhotos();
    },
    methods: {
        fetchPhotos() {
            const apiUrl = 'http://localhost:8080/api/v1.0/photos';
            axios.get(apiUrl)
                .then(response => {
                    this.photos = response.data;
                    this.originalPhotos = response.data;
                    console.log('Dati ricevuti:', this.pizzas);
                })
                .catch(error => {
                    console.error('Errore durante la chiamata:', error);
                });
        },
        searchPhotos() {
            if (this.searchQuery.trim() === '') {
                this.photos = this.originalPhotos;
                return;
            }

            const filteredPhotos = this.originalPhotos.filter(photo => {
                return photo.titolo.toLowerCase().includes(this.searchQuery.toLowerCase());
            });

            this.photos = filteredPhotos;

            console.log('Dati della ricerca:', this.photos);
        },
    }
}
</script>

<template>
    <h1>Foto</h1>
    <form @submit.prevent="searchPhotos" method="get">
        <input v-model="searchQuery" @input="searchPhotos" type="text" placeholder="Cerca una Foto ">
    </form>
    <ul>
        <li v-for="photo in photos" :key="photo.id">
            {{ photo.titolo }}
            <br>
            {{ photo.descrizione }}
            <div v-if="photo.url == ''">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"
                    alt="">
            </div>
            <div>
                <img :src="photo.url" alt="">
            </div>

        </li>
    </ul>
</template>

<style></style>
