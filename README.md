# musinsa-homework

[MUSINSA] Java(Kotlin) Backend Engineer - 과제

## 프로젝트 개요

이 서비스는 특정 카테고리에서 최저가 브랜드와 상품 가격을 조회하거나, 단일 브랜드로 모든 카테고리 상품을 구매할 때의 최저가를 조회할 수 있는 API를 제공합니다.
또한, 운영자가 브랜드 및 상품을 추가, 업데이트, 삭제할 수 있는 기능을 포함하고 있습니다.

## 기능 설명

### 1. 카테고리별 최저 가격 브랜드와 상품 가격, 총액 조회 API

- **엔드포인트**: `/api/v1/commodity/lowest-price-by-category`
- **기능 설명**: 고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다.

### 2. 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저 가격 조회 API

- **엔드포인트**: `/api/v1/commodity/lowest-sum-price-by-brand`
- **기능 설명**: 고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다.

### 3. 카테고리별 최저 및 최고 가격 브랜드와 상품 가격 조회 API

- **엔드포인트**: ` /api/v1/commodity/lowest-and-highest-price-by-brand/{categoryName}`
- **기능 설명**: 고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다.

### 4. 브랜드 및 상품 관리 API

- **엔드포인트**: `/api/v1/commodity`, `/api/v1/brand`
- **기능 설명**:운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.


## 백엔드 기술 스택

- **언어**: Java

- **프레임워크**: Spring Boot
   
- **데이터베이스**: H2 Database (로컬 인메모리 데이터베이스)

- **빌드 도구**: Maven

- **테스트**: JUnit, Spring Test

## 프론트엔드 기술 스택

- **언어**: JavaScript

- **프레임워크**: Vue 3

- **빌드 도구**: Vite

- **스타일링**: Tailwind CSS

- **패키지 매니저**: npm


## 설치 및 실행 방법

### 백엔드
1. **프로젝트 클론**
   ```bash
   git clone https://github.com/yoonxjoong/musinsa-homework.git
   cd musinsa-homework/bff-homework
   ```
   
2. **의존성 설치**
   ```bash
   mvn clean install
   ```
   
3. **프로젝트 테스트**
   ```bash
   mvn test
   ```
   
4. **프로젝트 컴파일**
   -  QueryDsl 메타 모델 클래스 생성을 하기 위해 필요
   ```bash
   mvn compile
   ```
   
5. **애플리케이션 실행**
   ```bash
   mvn spring-boot:run
   ```

### 프론드엔드
1. **의존성 설치**:
    ```bash
    npm install
    ```

2. **개발 서버 실행**:
    ```bash
    npm run dev
    ```

3. **프로덕션 빌드**:
    ```bash
    npm run build
    ```

4. **서버 접속**
  ```bash
  http://localhost:5173 으로 접속 (CORS 허용)
  ```








