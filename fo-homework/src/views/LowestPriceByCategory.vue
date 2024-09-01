<script setup>
import { ref, onMounted } from 'vue';
import axiosInstance from '../axios.js'; // axios 설정 파일을 가져옵니다.
import CommodityComponent from "../components/CommodityComponent.vue";
import CommodityComponent2 from "../components/CommodityComponent2.vue";

const rows = ref([]); // rows 데이터를 관리하는 ref
const sumPrice = ref();
onMounted(async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/lowest-price-by-category');
    rows.value = response.data.data.commodities;
    sumPrice.value = response.data.data.sumPrice.toLocaleString('ko-KR');
  } catch (error) {
    alert('서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.');
  }
});
</script>

<template>
  <div class="p-6 bg-gray-50 min-h-screen">
    <!-- Sum Price Display -->
    <section class="bg-white p-6 rounded-lg shadow-md mb-8">
      <h2 class="text-xl font-semibold text-gray-800 mb-4">총액</h2>
      <div class="mt-4 flex items-center justify-between">
        <span class="font-medium text-green-600 text-xl">{{ sumPrice }} 원</span>
      </div>
    </section>

    <section class="bg-white p-6 rounded-lg shadow-md mb-8">
      <h2 class="text-xl font-semibold text-gray-800 mb-4">상품 리스트</h2>
      <CommodityComponent :rows="rows" />
    </section>
  </div>
</template>

<style scoped>

</style>

