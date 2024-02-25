package org.shmk.backend.controller

import com.azure.storage.queue.implementation.MessagesImpl.MessagesService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["메시지"])
@RestController
class TestSwaggerController(private val messageService: MessagesService) {
/*
    @ApiOperation(value = "카테고리로 메시지 조회")
    @GetMapping("/categeory/messages")
    fun getCategoryMessage(
        @ApiParam(value = "메인 카테고리 ID") @RequestParam("mainCategoryId") mainCategoryId: Long,
        @ApiParam(value = "서브 카테고리 ID") @RequestParam("subCategoryId") subCategoryId: Long,
    ): List<MessagesService> = messageService.find*/
}