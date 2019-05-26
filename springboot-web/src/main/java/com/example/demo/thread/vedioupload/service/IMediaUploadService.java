package com.example.demo.thread.vedioupload.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.vo.CheckChunkResultVo;
import com.example.demo.vo.ResponseResultVo;

public interface IMediaUploadService {

	ResponseResultVo register(String fileMd5, String fileName, String fileSize, String mimetype, String fileExt);

	CheckChunkResultVo checkchunk(String fileMd5, String chunk, String chunkSize);

	ResponseResultVo uploadchunk(MultipartFile file, String fileMd5, String chunk);

	ResponseResultVo mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);
}
