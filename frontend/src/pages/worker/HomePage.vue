<template>
    <div class="mainpage">
        <div class="grid-container">
            <div class="selection-container">
                <p>Hello {{ store.getName }}!</p>
            </div>
            <div class="selection-container">
                <router-link to="/login"><base-button>Log Out</base-button></router-link>
            </div>
            <div class="selection-container">
                <p class="date-time-info"><img src="../../assets/clock.png"> <span>{{store.getDate}}</span> <span>{{store.getTime}}</span></p>
            </div>
            <div class="button-container">
                    <div v-if="!store.getStatus">
                        <p class="question">What would you like to do?</p>
                        <base-button class="flex-button" size="tall-buttons" @click="startShift">🕣↶ Clock In <span>→</span></base-button>
                        <base-button class="flex-button" size="tall-buttons">💰📚 View PayRoll History <span>→</span></base-button>
                    </div>
                    <div v-else>
                        <p class="question">What would you like to do?</p>
                        <base-button class="more-height flex-button" size="big-buttons">☕️ 10 minute break <span>→</span></base-button>
                        <base-button class="more-height flex-button" size="big-buttons">☕️ 30 minute break <span>→</span></base-button>
                        <base-button class="more-height flex-button" size="big-buttons" @click="endShift">🕣↷ Clock Out <span>→</span></base-button>
                        <base-button class="more-height flex-button" size="big-buttons">💰📚 View PayRoll History <span>→</span></base-button>
                    </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { useStorageStore } from '../../stores/storage.js';
import BaseButton from '../../components/ui/BaseButton.vue';


export default {
  components: { BaseButton },
    data(){
        return{
            store: useStorageStore(),
        };
    },
    methods:{
        makeRecord(){
            console.log('this is added =>' + this.store.sqlDateFormat());
            console.log('this is added =>' + this.store.sqlTimeFormat());
            axios.post('http://localhost:1111/data/ClockInUser', {
                // Request body data
                "pin": this.store.getPin,
                "date": this.store.sqlDateFormat(),
                "time": this.store.sqlTimeFormat()
            })
            .catch(error => {
                // Handle error
                console.error('There was an error!', error);
            });
        },
        updateClockInStatus(status){
            axios.put('http://localhost:1111/data/updateClockInStatus/' + this.store.getPin + '/' + status)
            .catch(error => {
                console.error('There was an error!', error);
            });
        },
        startShift(){
            this.updateClockInStatus(1);
            // this.makeRecord()
            this.$router.push('/clocked-in');
        },
        endShift(){
            this.updateClockInStatus(0);
            // this.makeRecord()
            this.$router.push('/clocked-out');
        }
    }
}
</script>

<style scoped>
.mainpage {
  height: auto; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; 
  background-color: white;
  margin-left: 20%;
  margin-right: 20%;
  border-radius: 0%;
  border: 5px solid black;
}

.question{
    font-size: 1.5rem;
    font-weight: bolder;
    margin-bottom: 10px;
}

.date-time-info{
    display: flex;
    flex-direction: column;
}

.flex-button{
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.grid-container {
    display: grid;
    grid-template-columns: 50% 50%;
    padding: 30px;
}

img {
    max-width: 100%;
    height: auto;
}

.selection-container {
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
}
.button-container{
    display: flex;
    flex-direction: column;
    height: auto;
}
.button-container .question{
    display: flex;
    justify-content: flex-start;
}


p {
    font-size: 30px;
    font-weight: bolder;
}

.menu {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    padding: 20px;
    padding-right: 50px;

}



</style>