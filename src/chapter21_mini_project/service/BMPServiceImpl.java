package chapter21_mini_project.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.DAO.BMPBooksDAO;
import chapter21_mini_project.DAO.BMPCartDAO;
import chapter21_mini_project.DAO.BMPCustomerDAO;
import chapter21_mini_project.VO.BMPBooksVO;
import chapter21_mini_project.VO.BMPCartVO;
import chapter21_mini_project.VO.BMPCustomerVO;
import chapter21_mini_project.app.BookMiniProjectSystem;

public class BMPServiceImpl implements BMPService {
	// Field
	Scanner scan;
	BookMiniProjectSystem bms;
	BMPCustomerDAO customerRepository;
	BMPBooksDAO booksRepository;
	BMPCartDAO cartRepository;
	BMPCustomerVO customer;
		
	// Construct
	public BMPServiceImpl() {

	};
	
	public BMPServiceImpl(BookMiniProjectSystem bms) {
		this.bms = bms;
		this.scan = bms.scan;
		booksRepository = new BMPBooksDAO();
		cartRepository = new BMPCartDAO();
	};	
	
	// Method
	// 계정 생성
	public int createAccount(String name, String phone, String addr) {
		int result = 0;
		customerRepository = new BMPCustomerDAO();
		// 계정 정보 설정
		customer.setcName(name);
		customer.setcPhone(phone);
		customer.setcAddr(addr);
		
		// 계정 정보 등록
		result = customerRepository.insert(customer);
		
		if(result !=0) {
			System.out.println("회원가입에 성공했습니다.");
			// 로그인
			login(name, phone);
			
			if(customer.getcId() != null) {
				System.out.println("로그인 성공");
			}
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		 return result;
	}
	
	// 로그인
	public boolean login(String name, String phone) {
		boolean result = false;
		customerRepository = new BMPCustomerDAO();
		customer = customerRepository.find(name, phone);
			
		if(customer.getcId() != null) {
			result = true;
		}
		
		return result;
	}

	@Override
	// 고객 정보 확인
	public void menuGuestInfo() {
		System.out.println("현재 고객 정보");
		System.out.println("이름  : " + customer.getcName());
		System.out.println("연락처 : " + customer.getcPhone());
	}	
	
	@Override
	// 장바구니 상품 목록 확인
	public void menuCartItemList() {
		// 장바구니에 고객의 데이터가 존재 할 경우
		if(cartRepository.getCount(customer.getcId()) != 0 ) {
			List<BMPCartVO> list = new ArrayList<BMPCartVO>();
			list = cartRepository.findAll(customer.getcId());
			
			// 장바구니 목록 표시
			showCartItemList(list);
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}

	@Override
	// 장바구니 비우기
	public void menuCartClear() {
		// 장바구니에 고객의 데이터가 존재 할 경우
		if(cartRepository.getCount(customer.getcId()) != 0 ) {
			System.out.print("장바구니의 모든 항목을 삭제하시겠습니까? (Y / N)");
			String check = scan.next();
			
			// y 또는 Y를 입력했을 경우
			if(check.equals("Y") || check.equals("y")) {
				// 삭제처리
				if(cartRepository.remove(customer.getcId()) != 0) {
					System.out.println("장바구니의 모든 항목을 삭제했습니다.");
				} else {
					System.out.println("장바구니 비우기에 실패하였습니다.");
				}
			} else {
				System.out.println("장바구니 비우기 처리를 취소합니다.");
			}
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}

	@Override
	// 장바구니에 항목 추가하기
	public void menuCartAddItem() {
		List<BMPBooksVO> list = new ArrayList<BMPBooksVO>();
		String cid = customer.getcId();
		String bid;
		int result = 0;
		boolean flag = true;
		
		list = booksRepository.findAll();
		
		System.out.println("도서 상품 목록 : ");
		System.out.println("---------------------------------");
		
		for(BMPBooksVO bmpBooks : list) {
			System.out.print(bmpBooks.getbId() + " | ");
			System.out.print(bmpBooks.getbTitle() + " | ");
			System.out.print(bmpBooks.getbPrice() + " | ");
			System.out.print(bmpBooks.getbAuthor() + " | ");
			System.out.print(bmpBooks.getbSubTitle() + " | ");
			System.out.print(bmpBooks.getbGroup() + " | ");
			System.out.print(bmpBooks.getbDate() + " | ");
			System.out.println();
		}
		
		System.out.print("장바구니에 추가할 도서ID를 입력하세요. : ");
		bid = scan.next();
		
		// 입력된 도서 ID 확인
		for(BMPBooksVO bmpBooks : list) {
			if(bmpBooks.getbId().equals(bid)) {
				BMPCartVO bmpCart = cartRepository.find(cid, bid);

				// 기존에 카트에 존재할 경우
				if(bmpCart.getbId() != null) {
					// 카운트 갯수 1상승
					bmpCart.setCount(bmpCart.getCount() + 1);
					// 책의 금액 X 카운트
					bmpCart.setTotal(bmpBooks.getbPrice() * bmpCart.getCount());
					// 기존 레코드 변경
					result = cartRepository.update(bmpCart);
				} else {
					// 도서 아이디 설정
					bmpCart.setbId(bid);
					// 카운트 1설정
					bmpCart.setCount(1);
					// 도서 금액 설정
					bmpCart.setTotal(bmpBooks.getbPrice());
					// 고객 아이디 설정
					bmpCart.setcId(cid);
					
					// 신규 레코드 추가
					result = cartRepository.insert(bmpCart);
				}
				
				// 장바구니 추가 성공
				if(result != 0) {
					System.out.println(bmpCart.getbId() + " 도서가 장바구니에 추가되었습니다.");
				} else {
					System.out.println(bmpCart.getbId() + " 도서의 장바구니 추가가 실패하였습니다.");
				}
				
				flag = false;
				break;
			}
		}
		
		// 도서가 존재하지 않을경우
		if(flag) {
			System.out.println("존재하지 않는 도서 번호입니다.");
		}
	}
	
	@Override
	// 장바구니의 항목 수량 줄이기
	public void menuCartRemoveItemCount() {
		// 장바구니에 고객의 데이터가 존재 할 경우
		if(cartRepository.getCount(customer.getcId()) != 0 ) {
			String cid = customer.getcId();
			int totalCount = 0;
			
			List<BMPCartVO> list = new ArrayList<BMPCartVO>();
			list = cartRepository.findAll(cid);
			// 장바구니 목록 표시
			showCartItemList(list);
			
			System.out.print("장바구니에서 갯수를 줄일 도서의 ID를 입력해주세요. : ");
			String bid = scan.next();
			
			for(BMPCartVO bmpCart : list) {
				// 장바구니에 입력한 도서 아이디가 존재할 경우
				if(bid.equals(bmpCart.getbId())) {
					boolean flag = true;
					int bCount = bmpCart.getCount();
					
					while(flag) {
						totalCount++;
						// 5회이상 잘못 입력시 초기화면으로 이동
						if(totalCount > 5) {
							System.out.println("※※※5회 이상 잘못 입력했습니다. 초기화면으로 돌아갑니다.");
							break;
						}
						
						System.out.print("줄일 갯수를 입력해주세요.(해당 도서의 갯수 "+ bCount + " ) : ");
						int count = 0; 
						
						if(scan.hasNextInt()) {
							count = scan.nextInt();
							// 0을 입력한 경우
							if(count == 0) {
								System.out.println("0을 입력하셨습니다. 다시 입력해주세요.");
							}
							// 장바구니의 갯수가 입력한 값보다 크거나 같을 경우
							else if(bCount >= count) {
								// 도서 1개의 금액
								int price = (bmpCart.getTotal() / bCount);
								// 기존 도서 카운트 - 입력한 카운트
								bmpCart.setCount(bCount - count);
								// 도서 1개 금액 * 도서 카운트
								bmpCart.setTotal(price * bmpCart.getCount());
								
								if(bmpCart.getCount() == 0) {
									// 도서 카트 테이블에서 삭제
									cartRepository.remove(cid, bid);
								} else {
									// 도서 카트 테이블 갱신
									cartRepository.update(bmpCart);
								}
								flag = false;
							} else {
								System.out.println("장바구니에 담겨있는 갯수보다 많이 입력했습니다. 다시 입력해주세요.");
							}
						} else {
							System.out.println("숫자를 입력해주세요.");
							scan.next();
						}
					}
				}
			}
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}

	@Override
	// 장바구니의 항목 삭제하기
	public void menuCartRemoveItem() {
		// 장바구니에 고객의 데이터가 존재 할 경우
		if(cartRepository.getCount(customer.getcId()) != 0 ) {
			List<BMPCartVO> list = new ArrayList<BMPCartVO>();
			String cid = customer.getcId();
			// 장바구니 목록 취득
			list = cartRepository.findAll(cid);
			// 도서 아이디
			String bid;
			// 장바구니 도서아이디 확인
			boolean flag = true;
			
			// 장바구니 목록 표시
			showCartItemList(list);
			
			System.out.print("장바구니에서 삭제할 도서의 ID를 입력해주세요. : ");
			bid = scan.next();
			
			for(BMPCartVO bmpCart : list) {
				// 장바구니에 입력한 도서 아이디가 존재할 경우
				if(bid.equals(bmpCart.getbId())) {
					System.out.print("장바구니의 항목을 삭제 하시겠습니까? (Y / N)");
					String check = scan.next();
					
					if(check.equals("Y") || check.equals("y")) {
						int result = cartRepository.remove(cid, bid);
						
						if(result != 0) {
							System.out.println(bmpCart.getbId() + " 도서가 장바구니에서 삭제되었습니다.");
						} else {
							System.out.println(bmpCart.getbId() + " 도서의 장바구니 삭제에 실패하였습니다.");
						}
						
					} else {
						System.out.println("장바구니 삭제 처리를 취소합니다.");
					}
					
					flag = false;
					break;
				}			
			}
			
			if(flag) {
				System.out.println("존재하지 않는 도서 번호입니다.");
			}
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}

	@Override
	public void menuCartBill() {
		// 장바구니에 고객의 데이터가 존재 할 경우
		if(cartRepository.getCount(customer.getcId()) != 0 ) {
			String name;
			String phone;
			String addr;
			int total = 0;
			
			System.out.print("배송받을 분은 고객정보와 같습니까? ( Y / N )");
			String check = scan.next();
			
			// 현재 시간 취득 yyyy-mm-dd 형식
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = now.format(formatter);
			
	        // Y 또는 y를 입력할 경우 기존 고객 정보 입력
			if(check.equals("Y") || check.equals("y")) {
				name = customer.getcName();
				phone = customer.getcPhone();
				addr = customer.getcAddr();
			} else {
				System.out.print("배송받을 고객명을 입력해주세요. : ");
				name = scan.next();
				
				System.out.print("배송받을 고객의 연락처를 입력해주세요.(010-1234-5678) : ");
				phone = scan.next();
				
				System.out.print("배송받을 고객의 배송지를 입력해주세요.(서울시 강남구) : ");
				addr = scan.next();
			}
			
			System.out.println("------------배송 받을 고객 정보---------------");
			System.out.print("고객명 : " + name + "\t\t");
			System.out.print("연락처 : " + phone + "\n");
			System.out.print("배송지 : " + addr + "\t");
			System.out.print("배송지 : " + formattedDate + "\n");
			
			// 장바구니 리스트
			List<BMPCartVO> list = new ArrayList<BMPCartVO>();
			list = cartRepository.findAll(customer.getcId());
			
			// 장바구니 목록 표시
			showCartItemList(list);
			
			for(BMPCartVO bmpCart : list) {
				// 장바구니의 총 금액 설정
				total += bmpCart.getTotal();
			}
			
			System.out.println("\t 주문 총 금액 : " + total + "원");
			System.out.println("---------------------------------");
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}
	
	// 장바구니 목록 표시
	private void showCartItemList(List<BMPCartVO>list) {
		System.out.println("장바구니 상품 목록 : ");
		System.out.println("---------------------------------");
		System.out.println("도서ID\t\t 수량\t 합계");
		
		for(BMPCartVO bmpCart : list) {
			System.out.println(bmpCart.getbId()+ "\t " + bmpCart.getCount() + "\t " + bmpCart.getTotal());
		}
		
		System.out.println("---------------------------------");		
	}

	@Override
	// 종료
	public void menuExit() {
		customerRepository.close();
		booksRepository.close();
		cartRepository.close();
		System.exit(0);
	}
	
}
