<template>
  <div class="p-6 bg-gray-50 min-h-screen">
    <!-- 프로젝트 개요 -->
    <section class="mb-8">
      <h2 class="text-3xl font-extrabold text-gray-800 mb-4">프로젝트 개요</h2>
      <p class="text-gray-700 leading-relaxed">
        이 서비스는 특정 카테고리에서 최저가 브랜드와 상품 가격을 조회하거나, 단일 브랜드로 모든 카테고리 상품을 구매할 때의 최저가를 조회할 수 있는 API를 제공합니다.
        또한, 브랜드 및 상품을 추가, 업데이트, 삭제할 수 있는 기능을 포함하고 있습니다.
      </p>
    </section>

    <!-- 기능 설명 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-4">기능 설명</h3>

      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
        <h4 class="text-xl font-semibold text-gray-800 mb-2">1. 카테고리별 최저 가격 브랜드와 상품 가격, 총액 조회 API</h4>
        <p class="text-gray-700"><strong>엔드포인트:</strong> <code>/api/v1/commodity/lowest-price-by-category</code>  (GET)</p>
        <p class="text-gray-600">고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다.</p>
      </div>

      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
        <h4 class="text-xl font-semibold text-gray-800 mb-2">2. 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저 가격 조회 API</h4>
        <p class="text-gray-700"><strong>엔드포인트:</strong> <code>/api/v1/commodity/lowest-sum-price-by-brand (GET)</code></p>
        <p class="text-gray-600">고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다.</p>
      </div>

      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
        <h4 class="text-xl font-semibold text-gray-800 mb-2">3. 카테고리별 최저 및 최고 가격 브랜드와 상품 가격 조회 API</h4>
        <p class="text-gray-700"><strong>엔드포인트:</strong> <code>/api/v1/commodity/lowest-and-highest-price-by-brand/{categoryName} (GET)</code>
        </p>
        <p class="text-gray-600">고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다.</p>
      </div>

      <div class="bg-white p-4 rounded-lg shadow-md">
        <h4 class="text-xl font-semibold text-gray-800 mb-2">4. 브랜드 및 상품 관리 API</h4>
        <p class="text-gray-700"><strong>엔드포인트:</strong> <code>/api/v1/commodity (GET, POST, PUT, DELETE)</code>, <code>/api/v1/brand(GET, POST, PUT, DELETE)</code></p>
        <p class="text-gray-600">운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.</p>
      </div>
    </section>

    <!-- 백엔드 기술 스택 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-4">백엔드 기술 스택</h3>
      <ul class="list-disc list-inside text-gray-700 space-y-2">
        <li><strong>언어:</strong> Java</li>
        <li><strong>프레임워크:</strong> Spring Boot</li>
        <li><strong>데이터베이스:</strong> H2 Database (로컬 인메모리 데이터베이스)</li>
        <li><strong>빌드 도구:</strong> Maven</li>
        <li><strong>테스트:</strong> JUnit, Spring Test</li>
      </ul>
    </section>

    <!-- 프론트엔드 기술 스택 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-4">프론트엔드 기술 스택</h3>
      <ul class="list-disc list-inside text-gray-700 space-y-2">
        <li><strong>언어:</strong> JavaScript</li>
        <li><strong>프레임워크:</strong> Vue 3</li>
        <li><strong>빌드 도구:</strong> Vite</li>
        <li><strong>스타일링:</strong> Tailwind CSS</li>
        <li><strong>패키지 매니저:</strong> npm</li>
      </ul>
    </section>

    <!-- 설치 및 실행 방법 -->
    <section>
      <h3 class="text-2xl font-semibold text-gray-800 mb-4">설치 및 실행 방법</h3>

      <!-- 백엔드 -->
      <div class="mb-8">
        <h4 class="text-xl font-semibold text-gray-800 mb-2">백엔드</h4>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">1. 프로젝트 클론</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
git clone https://github.com/yoonxjoong/musinsa-homework.git
cd musinsa-homework/bff-homework
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">2. 의존성 설치</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
mvn clean install
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">3. 프로젝트 테스트</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
mvn test
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md">
          <p class="text-gray-800 font-semibold">4. 애플리케이션 실행</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
mvn spring-boot:run
          </pre>
        </div>
      </div>

      <!-- 프론트엔드 -->
      <div>
        <h4 class="text-xl font-semibold text-gray-800 mb-2">프론트엔드</h4>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">1. 의존성 설치</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
npm install
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">2. 개발 서버 실행</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
npm run dev
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md mb-4">
          <p class="text-gray-800 font-semibold">3. 프로덕션 빌드</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
npm run build
          </pre>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-md">
          <p class="text-gray-800 font-semibold">4. 서버 접속</p>
          <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
http://localhost:5173 으로 접속 (CORS 허용)
          </pre>
        </div>
      </div>
    </section>
  </div>
</template>

