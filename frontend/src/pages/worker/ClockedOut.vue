<template>
    <div class="clockedoutpage">
        <h3>Hope you had a great shift {{ store.getName }}!</h3>
        <h3>Successfully Clocked Out on <span class="highlight">{{ store.getDate }}</span> at <span class="highlight">{{ store.getTime }}</span></h3>
        <router-link to="/login"><base-button>Log Out</base-button></router-link>
    </div>
</template>

<script>
import { useStorageStore } from '../../stores/storage.js';

export default {
    data(){
        return{
            store: useStorageStore(),
        };
    }
}
</script>

<style scoped>
.clockedoutpage {
  text-align: center; /* Horizontally center the content */
  display: flex;
  flex-direction: column;
  align-items: center; /* Vertically center the content */
  height: 30vh; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-top: 7%;
  margin-left: 25%;
  margin-right: 25%;
  border: 5px solid black;
}

h3{
    font-size: 25px;
    font-weight: lighter;
}

.highlight{
    font-size: 30px;
    font-weight: bold;
    
}
</style>