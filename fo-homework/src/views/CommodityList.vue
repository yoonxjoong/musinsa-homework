<script setup>
import { ref, onMounted } from 'vue';
import axiosInstance from '../axios.js'; // axios 설정 파일을 가져옵니다.

// 상태 정의
const commodities = ref([]);
const isLoading = ref(true);
const error = ref('');
const selectedCommodity = ref(null);
const isModalOpen = ref(false);
const isAddModalOpen = ref(false);
const isDeleteModalOpen = ref(false);
const newCommodity = ref({
  brandAutoSn: '',
  categoryAutoSn: '',
  price: null
});


const brands = ref([]);
const categories = ref([]);

// 데이터 fetch 함수 (샘플 데이터 사용)
const fetchCommodities = async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/all');
    commodities.value = response.data.data;

    isLoading.value = false;
  } catch (err) {
    error.value = '서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.';
    isLoading.value = false;
  }
};

const fetchBrands = async () => {
  try {
    const response = await axiosInstance.get('/v1/brand/all');
    brands.value = response.data.data;

    isLoading.value = false;
  } catch (err) {
    error.value = '서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.';
    isLoading.value = false;
  }
};

const fetchCategories = async () => {
  try {
    const response = await axiosInstance.get('/v1/category/all');
    categories.value = response.data.data;

    isLoading.value = false;
  } catch (err) {
    error.value = '서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.';
    isLoading.value = false;
  }
};

// 컴포넌트가 마운트될 때 데이터 fetch
onMounted(() => {
  fetchCommodities();
  fetchBrands();
  fetchCategories();
});

// 모달 열기
const openModal = (commodity) => {
  selectedCommodity.value = { ...commodity }; // 선택한 상품 정보를 복사
  isModalOpen.value = true; // 모달 열기
};

// 모달 닫기
const closeModal = () => {
  isModalOpen.value = false; // 모달 닫기
};

// 상품 수정 함수
const updateCommodity = async () => {
  try {
    // 실제 요청 코드
    await axiosInstance.put(`/v1/commodity/update/${selectedCommodity.value.commodityNo}`, selectedCommodity.value);
    // 수정 완료 후 데이터 새로고침
    alert("저장되었습니다.")
    await fetchCommodities();
    closeModal();
  } catch (error) {
    alert('상품 수정 중 오류가 발생했습니다.');
  }
};

// 추가 모달 열기
const openAddModal = () => {
  newCommodity.value = {
    brandAutoSn: '',
    categoryAutoSn: '',
    price: null
  }; // 새 상품 데이터 초기화
  isAddModalOpen.value = true;
};

// 추가 모달 닫기
const closeAddModal = () => {
  isAddModalOpen.value = false;
};

// 상품 추가 함수
const addCommodity = async () => {
  try {
    await axiosInstance.post('/v1/commodity/', newCommodity.value);
    alert("저장되었습니다.")
    // 추가 완료 후 데이터 새로고침
    await fetchCommodities();
    closeAddModal();
  } catch (error) {
    alert('상품 추가 중 오류가 발생했습니다.');
  }
};

// 삭제 모달 열기
const openDeleteModal = (commodity) => {
  selectedCommodity.value = commodity; // 선택한 상품 정보를 저장
  isDeleteModalOpen.value = true; // 삭제 모달 열기
};

// 삭제 모달 닫기
const closeDeleteModal = () => {
  isDeleteModalOpen.value = false; // 삭제 모달 닫기
};

// 상품 삭제 함수
const deleteCommodity = async () => {
  try {
    await axiosInstance.delete(`/v1/commodity/${selectedCommodity.value.commodityNo}`);
    // 삭제 완료 후 데이터 새로고침
    await fetchCommodities();
    closeDeleteModal();
  } catch (error) {
    alert('상품 삭제 중 오류가 발생했습니다.');
  }
};
</script>

<template>
  <div class="min-h-screen p-6 bg-gray-100">
    <div class="max-w-4xl mx-auto">
      <!-- 에러 메시지 -->
      <div v-if="error" class="mb-6 p-4 bg-red-100 border border-red-300 text-red-700 rounded-lg">
        {{ error }}
      </div>

      <!-- 로딩 상태 -->
      <div v-if="isLoading" class="flex justify-center items-center h-64">
        <span class="text-gray-500">로딩 중...</span>
      </div>

      <!-- 상품 리스트 -->
      <section v-if="!isLoading && !error" class="bg-white p-6 rounded-lg shadow-md">
        <div class="flex justify-between items-center mb-4">
          <h1 class="text-2xl font-bold text-gray-800">상품 리스트</h1>
          <button
              @click="openAddModal"
              class="bg-green-600 text-white px-4 py-2 rounded-md shadow-sm hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-green-500"
          >
            상품 추가
          </button>
        </div>
        <table class="min-w-full divide-y divide-gray-200">
          <thead class="bg-gray-50">
          <tr>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">상품 번호</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">브랜드</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">카테고리</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">가격</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">액션</th>
          </tr>
          </thead>
          <tbody class="bg-white divide-y divide-gray-200">
          <tr v-for="commodity in commodities" :key="commodity.commodityNo">
            <td class="px-6 py-4 whitespace-nowrap">{{ commodity.commodityNo }}</td>
            <td class="px-6 py-4 whitespace-nowrap">{{ commodity.brandNm }}</td>
            <td class="px-6 py-4 whitespace-nowrap">{{ commodity.categoryNm }}</td>
            <td class="px-6 py-4 whitespace-nowrap text-right">{{ commodity.price.toLocaleString('ko-KR') }} 원</td>
            <td class="px-6 py-4 whitespace-nowrap text-right">
              <button @click="openModal(commodity)" class="text-blue-500 hover:text-blue-700">수정</button>
              <button @click="openDeleteModal(commodity)" class="text-red-500 hover:text-red-700 ml-4">삭제</button>
            </td>
          </tr>
          </tbody>
        </table>
      </section>
    </div>

    <!-- 상품 수정 모달 -->
    <div v-if="isModalOpen" class="fixed inset-0 bg-gray-600 bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-6 rounded-lg shadow-md w-96">
        <h2 class="text-xl font-semibold mb-4">상품 수정</h2>
        <div class="mb-4">
          <label for="edit-brand" class="block text-sm font-medium text-gray-700">브랜드</label>
          <input
              id="edit-brand"
              v-model="selectedCommodity.brandNm"
              type="text"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          />
        </div>
        <div class="mb-4">
          <label for="edit-category" class="block text-sm font-medium text-gray-700">카테고리</label>
          <input
              id="edit-category"
              v-model="selectedCommodity.categoryNm"
              type="text"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          />
        </div>
        <div class="mb-4">
          <label for="edit-price" class="block text-sm font-medium text-gray-700">가격</label>
          <input
              id="edit-price"
              v-model.number="selectedCommodity.price"
              type="number"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          />
        </div>
        <div class="flex justify-end space-x-4">
          <button @click="updateCommodity" class="bg-blue-600 text-white px-4 py-2 rounded-md shadow-sm hover:bg-blue-700">저장</button>
          <button @click="closeModal" class="bg-gray-300 text-gray-700 px-4 py-2 rounded-md shadow-sm hover:bg-gray-400">취소</button>
        </div>
      </div>
    </div>

    <!-- 상품 추가 모달 -->
    <div v-if="isAddModalOpen" class="fixed inset-0 bg-gray-600 bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-6 rounded-lg shadow-md w-96">
        <h2 class="text-xl font-semibold mb-4">상품 추가</h2>
        <div class="mb-4">
          <label for="add-brand" class="block text-sm font-medium text-gray-700">브랜드</label>
          <select
              id="add-brand"
              v-model="newCommodity.brandAutoSn"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          >
            <option disabled value="">브랜드를 선택해주세요</option>
            <option v-for="brand in brands" :key="brand.brandAutoSn" :value="brand.brandAutoSn">{{ brand.name }}</option>
          </select>
        </div>
        <div class="mb-4">
          <label for="add-category" class="block text-sm font-medium text-gray-700">카테고리</label>
          <select
              id="add-category"
              v-model="newCommodity.categoryAutoSn"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          >
            <option disabled value="">카테고리를 선택해주세요</option>
            <option v-for="category in categories" :key="category.categoryAutoSn" :value="category.categoryAutoSn">{{ category.name }}</option>
          </select>
        </div>
        <div class="mb-4">
          <label for="add-price" class="block text-sm font-medium text-gray-700">가격</label>
          <input
              id="add-price"
              v-model.number="newCommodity.price"
              type="number"
              class="mt-1 p-2 border border-gray-300 rounded-md shadow-sm w-full"
          />
        </div>
        <div class="flex justify-end space-x-4">
          <button @click="addCommodity" class="bg-green-600 text-white px-4 py-2 rounded-md shadow-sm hover:bg-green-700">추가</button>
          <button @click="closeAddModal" class="bg-gray-300 text-gray-700 px-4 py-2 rounded-md shadow-sm hover:bg-gray-400">취소</button>
        </div>
      </div>
    </div>

    <!-- 상품 삭제 모달 -->
    <div v-if="isDeleteModalOpen" class="fixed inset-0 bg-gray-600 bg-opacity-50 flex items-center justify-center z-50">
      <div class="bg-white p-6 rounded-lg shadow-md w-96">
        <h2 class="text-xl font-semibold mb-4">상품 삭제 확인</h2>
        <p class="mb-4">정말로 이 상품을 삭제하시겠습니까?</p>
        <div class="flex justify-end space-x-4">
          <button @click="deleteCommodity" class="bg-red-600 text-white px-4 py-2 rounded-md shadow-sm hover:bg-red-700">삭제</button>
          <button @click="closeDeleteModal" class="bg-gray-300 text-gray-700 px-4 py-2 rounded-md shadow-sm hover:bg-gray-400">취소</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* 필요에 따라 추가 스타일 */
</style>
