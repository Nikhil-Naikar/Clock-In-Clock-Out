<template>
  <div class="center-content">
    <div class="container">
      <router-link class="remove-link-look" to="/"><header><h1>CLOCK IN / CLOCK OUT</h1></header></router-link>
    </div>
    <div>
      <!-- Here is where the page content changes based on the route links -->
      <router-view></router-view>
    </div>
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
.container{
  padding: 40px;
}
</style>
