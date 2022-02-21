package com.project.HMF.Dao;

import com.project.HMF.Dto.res.VendorImagesResDto;
import com.project.HMF.Model.VendorImages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorImagesDao extends CrudRepository<VendorImages,Integer> {

    @Query("select new com.project.HMF.Dto.res.VendorImagesResDto (vi.vendorImageId, vi.vendorImagePath, vi.vendorImageStatus) from VendorImages as vi where vi.vendorMaster.vendorId=:vendorId")
    List<VendorImagesResDto> findAllImagesByVendorId(@Param("vendorId")Integer vendorId);

    @Query("select new com.project.HMF.Dto.res.VendorImagesResDto (vi.vendorImageId, vi.vendorImagePath, vi.vendorImageStatus) from VendorImages as vi where vi.vendorMaster.vendorId=:vendorId")
    List<VendorImages> findAllImagesByVendorIdTwo(@Param("vendorId")Integer vendorId);

    @Query("select new com.project.HMF.Dto.res.VendorImagesResDto (vi.vendorImageId, vi.vendorImagePath, vi.vendorImageStatus) from VendorImages as vi where vi.vendorMaster.vendorId=:vendorId")
    List<VendorImagesResDto> getImagesListById(@Param("vendorId")Integer vendorId);
}
