<template>
    <div class="mainpage">
        <h2>Welcome {{ user }}!</h2>
        <div class="grid-two-col">
            <div>
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
export default {
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
  height: 50vh; /* Set the height to 100% of the viewport height for vertical centering */
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
    padding: 50px;
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



</style>