package vn.com.rabbit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.entity.CategoryPost;
import vn.com.rabbit.entity.Post;
import vn.com.rabbit.repository.AccountRepository;
import vn.com.rabbit.repository.CategoryReposytory;
import vn.com.rabbit.repository.PostRepository;
import vn.com.rabbit.service.PostService;
import vn.com.rabbit.service.dto.PostDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;
import vn.com.rabbit.service.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {

	private final PostRepository _repository;
	private final CategoryReposytory categoryReposytory;
	private final AccountRepository accountRepository;
	private final PostMapper _mapper;

	public PostServiceImpl(PostRepository repository, PostMapper mapper, CategoryReposytory categoryReposytory, AccountRepository accountRepository) {
		this._repository = repository;
		this._mapper = mapper;
		this.categoryReposytory = categoryReposytory;
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public void saveAndUpdate(PostDTO dto) {
		
		Post _post = _mapper.dtoToEntity(dto);

		_post.setCreatedBy("Anonymous");
		
		UUID[] _categorys = dto.getCategory();

		if (_categorys != null) {
			List<CategoryPost> _categoryPosts = new ArrayList<CategoryPost>();
			for (UUID id : _categorys) {
				Category ca = categoryReposytory.findOneCategoryById(id);
				if (ca != null) {
					CategoryPost categoryPost = new CategoryPost();
					categoryPost.setCategorys(ca);
					categoryPost.setPosts(_post);
					categoryPost.setCreatedBy("Anonymous");
					
					_categoryPosts.add(categoryPost);
				}

			}
			_post.setCategoryPosts(_categoryPosts);
		}
		
		Account author = accountRepository.findOneByLogin(dto.getUsers()).get();
		
		_post.setUsers(author);

		_repository.save(_post);
	}

	@Override
	public ResponseMess<Post> getAllPosts(Integer pageNo, Integer pageSize, String name, String sortType,
			String sortBy) {
		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Post> enties = _repository.findAllPost(pageable, name);

		ResponseMess<Post> postMess = new ResponseMess<Post>();
		postMess.setMessage("");
		postMess.setTotal(enties.getTotalElements());
		postMess.setValues(enties.getContent());

		return postMess;
	}

	@Override
	public Optional<Post> getOnePostById(UUID id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

	@Override
	public void delete(UUID id) {
		_repository.deleteById(id);
	}

	@Override
	public PostDTO getOnePostByUrl(String url) {
		Post post = _repository.findOneByUrl(url).get();
		
		if(post != null)
			return _mapper.entityToDTO(post);
			
		return null;
	}

}
