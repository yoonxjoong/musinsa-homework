<script setup>
import { ref } from 'vue';
import axiosInstance from '../axios.js'; // axios 설정 파일을 가져옵니다.

const categoryName = ref('');
const resultCategoryNm = ref('');
const lowestPriceCommodity = ref(null);
const highestPriceCommodity = ref(null);

// 데이터 fetch 함수
const fetchData = async (category) => {
  try {
    const encodedCategory = encodeURIComponent(category);
    const response = await axiosInstance.get(`/v1/commodity/lowest-and-highest-price-by-brand/${encodedCategory}`);

    if(response.status === 200) {
      lowestPriceCommodity.value = response.data.data.lowestPriceCommodity;
      highestPriceCommodity.value = response.data.data.highestPriceCommodity;
      resultCategoryNm.value = response.data.data.categoryNm;
    } else{
      lowestPriceCommodity.value = null;
      highestPriceCommodity.value = null;
      resultCategoryNm.value = '';
    }

  } catch (error) {
    alert('서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.');
  }
};

// 검색 버튼 클릭 핸들러
const handleButtonClick = () => {
  fetchData(categoryName.value);
};
</script>

<template>
  <div class="min-h-screen p-6 bg-gray-50">
    <!-- 카테고리 입력 필드와 버튼 -->
    <div class="flex items-center mb-6 space-x-4 bg-white p-4 rounded-lg shadow-md">
      <label for="category" class="block text-lg font-medium text-gray-700">카테고리 입력 :</label>

      <div class="flex-1">
        <input
            id="category"
            v-model="categoryName"
            type="text"
            placeholder="카테고리를 입력하세요"
            class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full focus:border-blue-500 focus:ring-1 focus:ring-blue-500"
        />
      </div>
      <button
          @click="handleButtonClick"
          class="bg-blue-600 text-white px-4 py-2 rounded-md shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500"
      >
        검색
      </button>
    </div>

    <div class="bg-white p-6 rounded-lg shadow-md">
      <!-- 카테고리 제목 -->
      <div class="mb-6">
        <h1 class="text-2xl font-bold mb-2 text-gray-800">검색된 카테고리 : {{ resultCategoryNm }}</h1>
      </div>

      <!-- 최저가 정보 -->
      <div v-if="lowestPriceCommodity" class="mb-6 bg-blue-50 p-4 rounded-lg shadow-md border border-blue-200">
        <h2 class="text-xl font-semibold mb-2 text-blue-700">최저가 : {{lowestPriceCommodity.price.toLocaleString('ko-KR')}}</h2>
        <ul>
          <li class="font-medium text-gray-700">브랜드 : {{lowestPriceCommodity.brandNm}}</li>
        </ul>
      </div>
      <div v-else class="mb-6 bg-white p-4 rounded-lg shadow-md border border-gray-200">
        <p class="text-lg font-semibold text-red-500">최저가 정보가 없습니다.</p>
      </div>

      <!-- 최고가 정보 -->
      <div v-if="highestPriceCommodity" class="bg-red-50 p-4 rounded-lg shadow-md border border-red-200">
        <h2 class="text-xl font-semibold mb-2 text-red-700">최고가 : {{highestPriceCommodity.price.toLocaleString('ko-KR')}}</h2>
        <ul>
          <li class="font-medium text-gray-700">브랜드 : {{highestPriceCommodity.brandNm}}</li>
        </ul>
      </div>
      <div v-else class="bg-white p-4 rounded-lg shadow-md border border-gray-200">
        <p class="text-lg font-semibold text-red-500">최고가 정보가 없습니다.</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* 필요에 따라 추가 스타일 */
</style>
