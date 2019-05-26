package com.example.demo.thread.vedioupload.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.thread.vedioupload.service.IMediaUploadService;
import com.example.demo.vo.CheckChunkResultVo;
import com.example.demo.vo.ResponseResultVo;

@Service
public class MediaUploadServiceImpl implements IMediaUploadService {

	@Override
	public ResponseResultVo register(String fileMd5, String fileName, String fileSize, String mimetype,
			String fileExt) {
		
		
		return null;
	}

	@Override
	public CheckChunkResultVo checkchunk(String fileMd5, String chunk, String chunkSize) {
		return null;
	}

	@Override
	public ResponseResultVo uploadchunk(MultipartFile file, String fileMd5, String chunk) {
		return null;
	}

	@Override
	public ResponseResultVo mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype,
			String fileExt) {
		return null;
	}

}
