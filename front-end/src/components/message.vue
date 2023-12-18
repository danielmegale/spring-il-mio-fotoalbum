<script>
import axios from 'axios';

export default {
    data() {
        return {
            message: {
                email: '',
                message: '',
            },
        };
    },
    methods: {
        addMessage() {
            const apiUrl = 'http://localhost:8080/api/v1.0/messages';

            axios.post(apiUrl, this.message)
                .then(response => {
                    console.log('Messaggio inviato:', response.data);

                    this.message = { email: '', message: '' };
                })
                .catch(error => {
                    console.error("Errore durante l'invio del messaggio:", error);
                });
        },
    },
};
</script>

<template>
    <div>
        <h1>Invia un Messaggio</h1>
        <form @submit.prevent="addMessage">
            <div>
                <label for="email">Email: </label>
                <input v-model="message.email" type="email" id="email" required>
            </div>
            <div>
                <label for="message">Messaggio: </label>
                <!-- <input type="text" v-model="pizza.descrizione" id="message" required> -->
                <textarea v-model="message.message" name="message" id="message" cols="30" rows="10"></textarea>
            </div>

            <button type="submit">Invia</button>
        </form>
    </div>
</template>

<style></style>
