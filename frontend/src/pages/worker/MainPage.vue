<template>
    <div class="mainpage">
        <div class="menu">
            <router-link to="/login"><base-button>Log Out</base-button></router-link>
        </div>
        <div class="grid-two-col">
            <div>
                <p>Welcome {{ user }}!</p>
                <img src="../../assets/clock.png">
            </div>
            <div class="selection-container">
                <base-button mode="big-buttons">10 min unpaid break</base-button>
                <base-button mode="big-buttons">30 min unpaid break</base-button>
                <base-button v-if="!isClockedIn"  mode="big-buttons" @click="startShift">Clock In</base-button>
                <base-button v-else  mode="big-buttons" @click="endShift">Clock Out</base-button>
            </div>
        </div>
    </div>
</template>

<script>
import BaseButton from '../../components/ui/BaseButton.vue';
export default {
  components: { BaseButton },
    data(){
        return{
            user: this.$route.params.id,
            isClockedIn: false
        };
    },
    // created(){
    //     //talk to backend to check if user is clocked in or not
    // },
    methods:{
        startShift(){
            this.$router.push('/'+this.user+'/ClockedIn');
        },
        endShift(){
            this.$router.push('/'+this.user+'/ClockedOut');
        },
    }
}
</script>

<style scoped>
.mainpage {
  height: auto; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-left: 20%;
  margin-right: 20%;
  border-radius: 10%;
  border: 5px solid black;
}

.grid-two-col {
    display: grid;
    grid-template-columns: 60% 40%;
    padding-right: 30px;
    padding-left: 30px;
    padding-bottom: 30px;
}

img {
    max-width: 100%;
    height: auto;
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
}

.selection-container {
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
}

p {
    margin-bottom: 0%;
    font-size: 30px;
    font-weight: bolder;
}

.menu {
    display: flex;
    justify-content: right;
    align-items: center;
    padding: 20px;
    padding-right: 50px;

}



</style>