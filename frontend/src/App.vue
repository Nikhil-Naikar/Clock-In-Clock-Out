<template>
  <div class="center-content">
    <router-link class="remove-link-look" to="/"><header><h1>CLOCK IN / CLOCK OUT</h1></header></router-link>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>

<style>
h1 {
  font-size: 50px;
  font-weight: bolder;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
}

.remove-link-look {
  text-decoration: none;
  color: black;
}
</style>
