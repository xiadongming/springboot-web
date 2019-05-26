package com.example.demo.thread.vedioupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.thread.vedioupload.service.IMediaUploadService;
import com.example.demo.vo.CheckChunkResultVo;
import com.example.demo.vo.ResponseResultVo;
@RestController
@RequestMapping("/media/upload")
public class MediaUploadController {

	@Autowired
	private IMediaUploadService mediaUploadService;
	//上传文件注册，在上传前作一些准备工作
	@PostMapping("/register")
	public ResponseResultVo register(@RequestParam("fileMd5") String fileMd5, @RequestParam("fileName") String fileName,
			@RequestParam("fileSize") String fileSize, @RequestParam("mimetype") String mimetype,
			@RequestParam("fileExt") String fileExt) {
		return mediaUploadService.register(fileMd5, fileName, fileSize, mimetype, fileExt);
	}
	//分块检查
	@PostMapping("/checkchunk")
	public CheckChunkResultVo checkchunk(@RequestParam("fileMd5") String fileMd5, @RequestParam("chunk") String chunk,
			@RequestParam("chunkSize") String chunkSize) {
		return mediaUploadService.checkchunk(fileMd5, chunk, chunkSize);
	}
	//分块上传，上传文件
	@PostMapping("/uploadchunk")
	public ResponseResultVo uploadchunk(@RequestParam("file") MultipartFile file, @RequestParam("fileMd5") String fileMd5,
			@RequestParam("chunk") String chunk) {
		return mediaUploadService.uploadchunk(file, fileMd5, chunk);
	}
	//合并文件
	@PostMapping("/mergechunks")
	public ResponseResultVo mergechunks(@RequestParam("fileMd5") String fileMd5,
			@RequestParam("fileName") String fileName, @RequestParam("fileSize") Long fileSize,
			@RequestParam("mimetype") String mimetype, @RequestParam("fileExt") String fileExt) {
		return mediaUploadService.mergechunks(fileMd5, fileName, fileSize, mimetype, fileExt);
	}
}
