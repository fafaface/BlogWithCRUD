<template>
  <div class="spots">
    <v-container>
      <CreateSpotItem v-if="$store.getters.isAdmin" @spot-changed="fetchData" />
      <v-select filled label="筛选类别" v-model="selected" :items="items" />
      <div class="text-center" v-if="loading">
        <v-progress-circular indeterminate color="primary" />
      </div>
      <template v-if="spots">
        <SpotItem
          v-for="spot in spots"
          :key="spot.id"
          :id="spot.id"
          :type="spot.type"
          :title="spot.title"
          :description="spot.description"
          :imgurl="spot.imgurl"
          @spot-changed="fetchData"
          class="mb-4"
        />
      </template>
    </v-container>
  </div>
</template>

<script>
import SpotItem from "../components/SpotItem.vue";
import CreateSpotItem from "../components/CreateSpotItem.vue";

export default {
  components: {
    CreateSpotItem,
    SpotItem,
  },
  data: function () {
    return {
      selected: "美食",
      loading: false,
      spots: null,
      error: null,
      items: ["美食", "美景", "风土人情"],
      dialog: false,
    };
  },

  created: function () {
    this.fetchData();
  },

  watch: {
    $route: "fetchData",
    selected: "fetchData",
  },

  methods: {
    fetchData: async function () {
      this.error = this.spots = null;
      this.loading = true;

      const params = new URLSearchParams();
      params.set("type", this.selected);

      const resp = await fetch(`/api/spots?${params.toString()}`);
      const respData = await resp.json();

      this.spots = respData.sort((a, b) => b.id - a.id);
      this.loading = false;
    },
  },
};
</script>
<style>
.spots {
  max-width: 960px;
  padding-top: 30px;
  margin: auto;
}
</style>