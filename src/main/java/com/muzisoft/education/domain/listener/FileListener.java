package com.muzisoft.education.domain.listener;

import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.utils.FileManagerUtils;

import javax.persistence.PreRemove;


public class FileListener {

    @PreRemove
    public void preRemove(EFileManager fileManager) {
        FileManagerUtils.delete(fileManager);
    }
}
