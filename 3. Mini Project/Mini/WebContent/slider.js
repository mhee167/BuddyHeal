document.addEventListener('DOMContentLoaded', function() {
    const slider = document.querySelector('.slider');
    const slideItems = slider.querySelectorAll('li');
    const prevBtn = document.querySelector('.btn_slide_prev');
    const nextBtn = document.querySelector('.btn_slide_next');
    let currentIndex = 0;

    // 버튼 상태 업데이트 (버튼 비활성화)
    function updateButtonState() {
        prevBtn.classList.toggle('disabled', currentIndex === 0);
        nextBtn.classList.toggle('disabled', currentIndex === slideItems.length - 1);
    }

    // 슬라이드 이동
    function moveSlide(offset) {
        const nextIndex = currentIndex + offset;
        // 인덱스 범위 내에서만 이동하게
        if (nextIndex >= 0 && nextIndex < slideItems.length) {
            currentIndex = nextIndex;
            const translateValue = -currentIndex * 100;

            slider.style.transform = `translateX(${translateValue}%)`;

            // 버튼 상태 업데이트
            updateButtonState();
        }
    }

    // prev 클릭 이벤트 리스너
    prevBtn.addEventListener('click', () => moveSlide(-1));
    // next 클릭 이벤트 리스너
    nextBtn.addEventListener('click', () => moveSlide(1));
    // 버튼 상태 업데이트
    updateButtonState();

    // 자동 슬라이드
    setInterval(() => moveSlide(1), 6000);
});