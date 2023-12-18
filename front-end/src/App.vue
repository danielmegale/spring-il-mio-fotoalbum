<script >
import index from './components/index.vue';
import message from './components/message.vue';

export default {
  components: {
    index,
    message,
  },
  data() {
    return {
      showIndex: true,
    };
  },
  methods: {
    toggleComponents() {
      this.showIndex = !this.showIndex;
    },
  },
};

</script>

<template>
  <button @click="toggleComponents">
    {{ showIndex ? 'Iniva un Messagio' : 'Mostra Index' }}
  </button>
  <index v-if="showIndex"></index>
  <message v-if="!showIndex"></message>
</template>

<style></style>
